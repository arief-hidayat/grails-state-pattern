package com.hida.imms.workorder

import com.hida.imms.ActionInfo
import grails.util.Holders

/**
 * Created by arief.hidayat on 24/06/2014.
 */
enum WorkOrderState implements WorkOrderStateAction {
    NEW ("NEW", "newActionService"),
    PLANNER_DRAFT ("PLANNER_DRAFT", "plannerDraftActionService"),
    ENGINEER_DRAFT ("ENGINEER_DRAFT", "engineerDraftActionService"),
    MANAGER_APPROVED ("MANAGER_APPROVED", "managerApprovedActionService"),
    MANAGER_REJECTED ("MANAGER_REJECTED", "managerRejectedActionService"),
    INVENTORY_RESERVED ("INVENTORY_RESERVED", "inventoryReservedActionService"),
    INVENTORY_RELEASED ("INVENTORY_RELEASED", "inventoryReleasedActionService"),
    WORK_IN_PROGRESS ("WORK_IN_PROGRESS", "workInProgressActionService"),
    WORK_INTERRUPTED ("WORK_INTERRUPTED", "workInterruptedActionService"),
    WORK_COMPLETED ("WORK_COMPLETED", "workCompletedActionService"),
    WORK_CLOSED  ("WORK_CLOSED", "workClosedActionService"),
    WORK_CANCELLED  ("WORK_CANCELLED", "workCancelledActionService")

    public WorkOrderState(String name, String serviceName) {
        this.name = name; this.serviceName = serviceName
    }

    private final String name
    private final String serviceName

    private WorkOrderStateAction _service

    private WorkOrderStateAction getService() {
        if(!_service)
            _service = Holders.applicationContext.getBean(serviceName)
        _service
    }

    @Override
    WorkOrderState next(WorkOrder item, ActionInfo actionInfo) {
        service.next(item, actionInfo)
    }

    @Override
    WorkOrderState save(WorkOrder item, ActionInfo actionInfo) {
        service.save(item, actionInfo)
    }

    @Override
    WorkOrderState back(WorkOrder item, ActionInfo actionInfo) {
        service.back(item, actionInfo)
    }

    public static WorkOrderState of(String name) {
        for(WorkOrderState state : WorkOrderState.values()) {
            if(state.name == name) return state
        }
        return null
    }

    @Override
    public String toString(){ name }
}
