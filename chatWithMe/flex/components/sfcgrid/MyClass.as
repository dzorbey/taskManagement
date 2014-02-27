package components.sfcgrid
{
	import mx.collections.ArrayCollection;
	
	[Bindable]
	public class MyClass
	{
		private var _a:int;
		private var _b: int;
		
		public var children:ArrayCollection = new ArrayCollection();
		
		public function get a():int
		{
			if (children.length == 0)
				return _a;
			else
			{
				var sum:int = 0;
				for each (var myObject:MyClass in children)
				sum += myObject.a;
				return sum;
			}
		}
		
		public function set a(value:int):void
		{
			_a = value;
		}
		
		public function get b():int
		{
			if (children.length == 0)
				return _b;
			else
			{
				var sum:int = 0;
				for each (var myObject:MyClass in children)
				sum += myObject.b;
				return sum;
			}
		}
		
		public function set b(value:int):void
		{
			_b = value;
		}
	}
	
}
