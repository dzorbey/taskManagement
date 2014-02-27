package components.sfcgrid
{
	import mx.containers.VBox;
	import mx.controls.AdvancedDataGrid;
	import mx.core.UIComponent;
	import mx.events.AdvancedDataGridEvent;
	import mx.events.IndexChangedEvent;
	
	public class myGrid extends VBox
	{
		private var _grid:AdvancedDataGrid;
		private var _footer:AdvancedDataGrid;
		
		public function myGrid()
		{
			// make sure there's no space between the grid
			// and the footer
			setStyle("verticalGap", 0); 
			
			_grid = new AdvancedDataGrid();
			_grid.percentWidth = 100;
			_grid.editable = "true";
			
			// if something in the grid updates the footer
			// needs an update; using ITEM_EDIT_END is
			// probably very blunt, but it does the trick
			_grid.addEventListener(
				AdvancedDataGridEvent.ITEM_EDIT_END,
				dataChanged);
			
			// if a column is moved in the grid, the column
			// of the footer must be moved too
			_grid.addEventListener(
				IndexChangedEvent.HEADER_SHIFT,
				columnMoved);
			
			// if a column is resized in the grid, the column
			// of the footer must be resized too
			_grid.addEventListener(
				AdvancedDataGridEvent.COLUMN_STRETCH,
				columnResized);
			
			addChild(_grid);
			
			_footer = new AdvancedDataGrid();
			_footer.headerHeight = 0;
			_footer.percentWidth = 100;
			_footer.rowCount = 1;
			_footer.selectable = false;
			addChild(_footer);
		}
		
		[Bindable]
		public function set columns(value:Array):void
		{
			_grid.columns = value;
			_footer.columns = value;
		}
		
		public function get columns():Array
		{
			return _grid.columns;
		}
		
		public function get dataProviderGrid():Object
		{
			return _grid.dataProvider;
		}
		
		[Bindable]
		public function set dataProviderGrid(value:Object):void
		{
			_grid.dataProvider = value;
		}
		
		public function get dataProviderFooter():Object
		{
			return _footer.dataProvider;
		}
		
		[Bindable]
		public function set dataProviderFooter(value:Object):void
		{
			_footer.dataProvider = value;
		} 
		
		private function dataChanged(event:AdvancedDataGridEvent):void
		{
			_footer.invalidateList();
		}
		
		private function  columnMoved(event:IndexChangedEvent):void
		{
			_footer.columns = _grid.columns;
		}
		
		private function columnResized(event:AdvancedDataGridEvent):void
		{
			_footer.invalidateList();
		}
	}
	
}
