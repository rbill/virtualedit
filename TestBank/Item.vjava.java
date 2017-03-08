package shoppingcart ; public class Item {
	String _id
	;
	double _price
	;
	Logger _logger
	;
	public Item ( String id , double price ) {
		_id = id;
		_price = price;
	}
	public String getID ( ) {
		{
			_logger.logp(( "Item" + ( "." + "getID" ) ));
		} return _id ;
	}
	public double getPrice ( ) {
		{
			_logger.logp(( "Item" + ( "." + "getPrice" ) ));
		} if ( _id.equals("PROD007")) {
			return ( _price / 10 ) ;
		} else {
			return _price ;
		} }
	public String toString ( ) {
		{
			_logger.logp(( "Item" + ( "." + "toString" ) ));
		} return ( "Item: " + _id ) ;
	}
	public static void main ( String [] args ) {
		{
			_logger.logp(( "Item" + ( "." + "main" ) ));
		} Item item = new Item ( "Item" , 5 );
		System.out.println(item);
	}
}