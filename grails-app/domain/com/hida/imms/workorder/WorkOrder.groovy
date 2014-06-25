package com.hida.imms.workorder

class WorkOrder {
    String workOrderNm
    String state

    Long wfProcessInstanceId
    String wfTaskId
    String wfTaskDescription
    static constraints = {
        wfProcessInstanceId nullable : true
        wfTaskId nullable : true
        wfTaskDescription nullable: true
    }
}
