/**
 * Generated by Gas3 v2.3.2 (Granite Data Services).
 *
 * WARNING: DO NOT CHANGE THIS FILE. IT MAY BE OVERWRITTEN EACH TIME YOU USE
 * THE GENERATOR. INSTEAD, EDIT THE INHERITED CLASS (spitterFooter.as).
 */

package org.example.dto {

    import flash.utils.IDataInput;
    import flash.utils.IDataOutput;
    import flash.utils.IExternalizable;
    import org.granite.tide.IPropertyHolder;

    [Bindable]
    public class spitterFooterBase implements IExternalizable {

        private var _idFooter:Number;
        private var _total:String;

        public function set idFooter(value:Number):void {
            _idFooter = value;
        }
        public function get idFooter():Number {
            return _idFooter;
        }

        public function set total(value:String):void {
            _total = value;
        }
        public function get total():String {
            return _total;
        }

        public function readExternal(input:IDataInput):void {
            _idFooter = function(o:*):Number { return (o is Number ? o as Number : Number.NaN) } (input.readObject());
            _total = input.readObject() as String;
        }

        public function writeExternal(output:IDataOutput):void {
            output.writeObject((_idFooter is IPropertyHolder) ? IPropertyHolder(_idFooter).object : _idFooter);
            output.writeObject((_total is IPropertyHolder) ? IPropertyHolder(_total).object : _total);
        }
    }
}