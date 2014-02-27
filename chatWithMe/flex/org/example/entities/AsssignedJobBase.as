/**
 * Generated by Gas3 v2.3.2 (Granite Data Services).
 *
 * WARNING: DO NOT CHANGE THIS FILE. IT MAY BE OVERWRITTEN EACH TIME YOU USE
 * THE GENERATOR. INSTEAD, EDIT THE INHERITED CLASS (AsssignedJob.as).
 */

package org.example.entities {

    import flash.utils.IDataInput;
    import flash.utils.IDataOutput;
    import org.granite.meta;
    import org.granite.tide.IEntityManager;
    import org.granite.tide.IPropertyHolder;

    use namespace meta;

    [Managed]
    public class AsssignedJobBase extends AbstractEntityCustom {

        private var _completed:Boolean;
        private var _currentSubTask:Task;
        private var _currentTask:Task;
        private var _lastprocessDate:Date;
        private var _process:MainProcess;

        public function set completed(value:Boolean):void {
            _completed = value;
        }
        public function get completed():Boolean {
            return _completed;
        }

        public function set currentSubTask(value:Task):void {
            _currentSubTask = value;
        }
        public function get currentSubTask():Task {
            return _currentSubTask;
        }

        public function set currentTask(value:Task):void {
            _currentTask = value;
        }
        public function get currentTask():Task {
            return _currentTask;
        }

        public function set lastprocessDate(value:Date):void {
            _lastprocessDate = value;
        }
        public function get lastprocessDate():Date {
            return _lastprocessDate;
        }

        public function set process(value:MainProcess):void {
            _process = value;
        }
        public function get process():MainProcess {
            return _process;
        }

        meta override function merge(em:IEntityManager, obj:*):void {
            var src:AsssignedJobBase = AsssignedJobBase(obj);
            super.meta::merge(em, obj);
            if (meta::isInitialized()) {
               em.meta_mergeExternal(src._completed, _completed, null, this, 'completed', function setter(o:*):void{_completed = o as Boolean}, false);
               em.meta_mergeExternal(src._currentSubTask, _currentSubTask, null, this, 'currentSubTask', function setter(o:*):void{_currentSubTask = o as Task}, false);
               em.meta_mergeExternal(src._currentTask, _currentTask, null, this, 'currentTask', function setter(o:*):void{_currentTask = o as Task}, false);
               em.meta_mergeExternal(src._lastprocessDate, _lastprocessDate, null, this, 'lastprocessDate', function setter(o:*):void{_lastprocessDate = o as Date}, false);
               em.meta_mergeExternal(src._process, _process, null, this, 'process', function setter(o:*):void{_process = o as MainProcess}, false);
            }
        }

        public override function readExternal(input:IDataInput):void {
            super.readExternal(input);
            if (meta::isInitialized()) {
                _completed = input.readObject() as Boolean;
                _currentSubTask = input.readObject() as Task;
                _currentTask = input.readObject() as Task;
                _lastprocessDate = input.readObject() as Date;
                _process = input.readObject() as MainProcess;
            }
        }

        public override function writeExternal(output:IDataOutput):void {
            super.writeExternal(output);
            if (meta::isInitialized()) {
                output.writeObject((_completed is IPropertyHolder) ? IPropertyHolder(_completed).object : _completed);
                output.writeObject((_currentSubTask is IPropertyHolder) ? IPropertyHolder(_currentSubTask).object : _currentSubTask);
                output.writeObject((_currentTask is IPropertyHolder) ? IPropertyHolder(_currentTask).object : _currentTask);
                output.writeObject((_lastprocessDate is IPropertyHolder) ? IPropertyHolder(_lastprocessDate).object : _lastprocessDate);
                output.writeObject((_process is IPropertyHolder) ? IPropertyHolder(_process).object : _process);
            }
        }
    }
}
