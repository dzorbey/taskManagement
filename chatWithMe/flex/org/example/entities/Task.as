/**
 * Generated by Gas3 v2.3.2 (Granite Data Services).
 *
 * NOTE: this file is only generated if it does not exist. You may safely put
 * your custom code here.
 */

package org.example.entities {

    [Bindable]
    [RemoteClass(alias="org.example.entities.Task")]
    public class Task extends TaskBase {
		
		public function get processNameDisplay():String {

			return this.mainProcess.name;
		}	
		
		public function get previousTaskNameDisplay():String {
			
			return this.previousTask.name;
		}	
		
		public function get nextTaskNameDisplay():String {
			
			return this.nextTask.name;
		}	
		
		public function get taskTypeNameDisplay():String {
			
			return this.taskType.name;
		}
    }
}