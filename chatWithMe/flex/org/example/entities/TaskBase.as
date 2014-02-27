/**
 * Generated by Gas3 v2.3.2 (Granite Data Services).
 *
 * WARNING: DO NOT CHANGE THIS FILE. IT MAY BE OVERWRITTEN EACH TIME YOU USE
 * THE GENERATOR. INSTEAD, EDIT THE INHERITED CLASS (Task.as).
 */

package org.example.entities {

    import flash.utils.IDataInput;
    import flash.utils.IDataOutput;
    import mx.collections.ListCollectionView;
    import org.granite.meta;
    import org.granite.tide.IEntityManager;
    import org.granite.tide.IPropertyHolder;

    use namespace meta;

    [Managed]
    public class TaskBase extends AbstractEntityCustom {

        private var _mainProcess:MainProcess;
        private var _maximumProcessDate:Date;
        private var _nextTask:Task;
        private var _previousTask:Task;
        private var _subTaskList:ListCollectionView;
        private var _taskType:TaskType;

        public function set mainProcess(value:MainProcess):void {
            _mainProcess = value;
        }
        [Lazy]
        public function get mainProcess():MainProcess {
            return _mainProcess;
        }

        public function set maximumProcessDate(value:Date):void {
            _maximumProcessDate = value;
        }
        public function get maximumProcessDate():Date {
            return _maximumProcessDate;
        }

        public function set nextTask(value:Task):void {
            _nextTask = value;
        }
        [Lazy]
        public function get nextTask():Task {
            return _nextTask;
        }

        public function set previousTask(value:Task):void {
            _previousTask = value;
        }
        [Lazy]
        public function get previousTask():Task {
            return _previousTask;
        }

        public function set subTaskList(value:ListCollectionView):void {
            _subTaskList = value;
        }
        [Lazy]
        public function get subTaskList():ListCollectionView {
            return _subTaskList;
        }

        public function set taskType(value:TaskType):void {
            _taskType = value;
        }
        [Lazy]
        public function get taskType():TaskType {
            return _taskType;
        }

        meta override function merge(em:IEntityManager, obj:*):void {
            var src:TaskBase = TaskBase(obj);
            super.meta::merge(em, obj);
            if (meta::isInitialized()) {
               em.meta_mergeExternal(src._mainProcess, _mainProcess, null, this, 'mainProcess', function setter(o:*):void{_mainProcess = o as MainProcess}, false);
               em.meta_mergeExternal(src._maximumProcessDate, _maximumProcessDate, null, this, 'maximumProcessDate', function setter(o:*):void{_maximumProcessDate = o as Date}, false);
               em.meta_mergeExternal(src._nextTask, _nextTask, null, this, 'nextTask', function setter(o:*):void{_nextTask = o as Task}, false);
               em.meta_mergeExternal(src._previousTask, _previousTask, null, this, 'previousTask', function setter(o:*):void{_previousTask = o as Task}, false);
               em.meta_mergeExternal(src._subTaskList, _subTaskList, null, this, 'subTaskList', function setter(o:*):void{_subTaskList = o as ListCollectionView}, false);
               em.meta_mergeExternal(src._taskType, _taskType, null, this, 'taskType', function setter(o:*):void{_taskType = o as TaskType}, false);
            }
        }

        public override function readExternal(input:IDataInput):void {
            super.readExternal(input);
            if (meta::isInitialized()) {
                _mainProcess = input.readObject() as MainProcess;
                _maximumProcessDate = input.readObject() as Date;
                _nextTask = input.readObject() as Task;
                _previousTask = input.readObject() as Task;
                _subTaskList = input.readObject() as ListCollectionView;
                _taskType = input.readObject() as TaskType;
            }
        }

        public override function writeExternal(output:IDataOutput):void {
            super.writeExternal(output);
            if (meta::isInitialized()) {
                output.writeObject((_mainProcess is IPropertyHolder) ? IPropertyHolder(_mainProcess).object : _mainProcess);
                output.writeObject((_maximumProcessDate is IPropertyHolder) ? IPropertyHolder(_maximumProcessDate).object : _maximumProcessDate);
                output.writeObject((_nextTask is IPropertyHolder) ? IPropertyHolder(_nextTask).object : _nextTask);
                output.writeObject((_previousTask is IPropertyHolder) ? IPropertyHolder(_previousTask).object : _previousTask);
                output.writeObject((_subTaskList is IPropertyHolder) ? IPropertyHolder(_subTaskList).object : _subTaskList);
                output.writeObject((_taskType is IPropertyHolder) ? IPropertyHolder(_taskType).object : _taskType);
            }
        }
    }
}
