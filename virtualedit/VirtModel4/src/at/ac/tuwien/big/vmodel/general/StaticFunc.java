package at.ac.tuwien.big.vmodel.general;

import at.ac.tuwien.big.virtmod.basic.VFunc;

/**A function where elements are never cleaned directly*/
public interface StaticFunc<T, U extends StaticElement> extends VFunc<T, U> {

}
