package add;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import at.hbot.ai.BoardStateRater.Valuation;
import at.hbot.model.state.SvmState;
import at.hbot.model.state.World;
import at.hbot.model.state.World.GameState;
import uk.ac.york.cs.ecss.fileutil.FilesManager;
import uk.ac.york.cs.ecss.learn.learnable.manager.IOPair;
import uk.ac.york.cs.ecss.learn.learnable.manager.SIManager;
import uk.ac.york.cs.ecss.learn.learnable.manager.ShapedValues;
import uk.ac.york.cs.ecss.learn.learnable.manager.SlotValueMap;
import uk.ac.york.cs.ecss.learn.learnable.manager.ValueDescManager;
import uk.ac.york.cs.ecss.learn.learnable.manager.weka.WekaInterface;
import uk.ac.york.cs.ecss.learn.learnformat.MyInputDesc;
import uk.ac.york.cs.ecss.ml.server.JobManager;

public class BasicWekaBoardStateRater implements AdaptBoardStateRater {
	
	public static final BasicWekaBoardStateRater INSTANCE;
	static {
		BasicWekaBoardStateRater set = null; 
		try {
			set = new BasicWekaBoardStateRater(new File("rater"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		INSTANCE = set;
	}
	
	public static BasicWekaBoardStateRater get() {
		return INSTANCE;
	}


	private BasicWekaBoardStateRater(File rootFile) throws IOException {
		SIManager simanager = new SIManager(rootFile);
		FilesManager fmanager = FilesManager.getManager(rootFile);
		vdm = new ValueDescManager(simanager, fmanager.getIOStream(Collections.emptyList()));
		vdm.read();
		sv = new WekaInterface(JobManager.INSTANCE);
		sv.setIOPair(fmanager.getIOStream(Collections.singletonList("model")), fmanager.getIOStream(Collections.singletonList("iopair")));
		sv.read();
		secondaryRater = new SimpleBoardStateRater(0.01);
	}
	
	ValueDescManager vdm;
	ShapedValues<?, ?, ?> sv;
	
	private boolean started = false;
	 
	private BoardStateRater secondaryRater;

	private boolean firstException = true;
	

	public  double guessWinPercentage(World board, Valuation valuation) {
		return rateBoardState(board, valuation);
	}
	
	@Override
	public double rateBoardState(World board, Valuation valuation) {
		if (board.getGameState() != GameState.Running) {
			switch(board.getGameState()) {
			case Player1Won: return board.getCurrentPlayer() == board.getPlayer1()?1.0:0.0;
			case Draw: return 0.5;
			case Player2Won: return board.getCurrentPlayer() == board.getPlayer2()?1.0:0.0;
			default:
				break;
			}
		}
		SvmState state = new SvmState();
		board.augmentVDM(state);
		MyInputDesc mid = state.getInput(vdm);
		double curPlayerWin = 0.0;
		try {
			double[] output = sv.guess(mid);
			curPlayerWin = output[0]+output[1]*0.5;
		} catch (Exception e) {
			if (firstException) {
				e.printStackTrace();
				System.err.println("Could not rate state ...: "+e.getMessage());
				firstException = false;
			}
		}
		if (curPlayerWin == 0.5 || curPlayerWin == 0.0) {
			curPlayerWin = 0.5+0.0000001*secondaryRater.rateBoardState(board, valuation);
		}
		return curPlayerWin;
	}

	@Override
	public double getPercentage() {
		return 0.01;
	}

	@Override
	public synchronized void adeptGame(List<World> worlds) {
		if (worlds.isEmpty()) {
			return;
		}
		World last = worlds.get(worlds.size()-1);
		GameState state = last.getGameState();
		List<IOPair> ioPairs = new ArrayList<IOPair>();
		World.getAllIOPairs(state, worlds, ioPairs, vdm);
		try {
			vdm.write();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		sv.addTrainings(ioPairs);
		if (!ioPairs.isEmpty()) {
			sv.startSlowProcessing();
		}
		try {
			sv.write();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
