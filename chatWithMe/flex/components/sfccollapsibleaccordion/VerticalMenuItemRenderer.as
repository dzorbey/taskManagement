package components.sfccollapsibleaccordion
{
    import mx.controls.menuClasses.MenuItemRenderer;
    import mx.controls.MenuBar;
  
    public class VerticalMenuItemRenderer extends MenuItemRenderer
    {
        private var leftMargin:int = 5;
        
        public function VerticalMenuItemRenderer()
        {
            super();
        }
        
        override protected function updateDisplayList(unscaledWidth:Number,
                                                  unscaledHeight:Number):void
        {
            super.updateDisplayList(unscaledWidth, unscaledHeight);

            if (branchIcon)
            {
                branchIcon.scaleX = -1;
                branchIcon.x = leftMargin + branchIcon.width;
            }
        }
    }
}


