package com.hida.imms.workorder

import grails.util.Holders

/**
 * Created by arief.hidayat on 24/06/2014.
 */
enum WorkOrderState implements WorkOrderStateAction {
    NEW ("newActionService"),
    PLANNER_DRAFT ("plannerDraftActionService"),
    ENGINEER_DRAFT ("engineerDraftActionService"),
    MANAGER_APPROVED ("managerApprovedActionService"),
    MANAGER_REJECTED ("managerRejectedActionService"),
    INVENTORY_RESERVED ("inventoryReservedActionService"),
    INVENTORY_RELEASED ("inventoryReleasedActionService"),
    WORK_IN_PROGRESS ("workInProgressActionService"),
    WORK_INTERRUPTED ("workInterruptedActionService"),
    WORK_COMPLETED ("workCompletedActionService"),
    WORK_CLOSED  ("workClosedActionService"),
    WORK_CANCELLED  ("workCancelledActionService")

    private final String serviceName

    private WorkOrderStateAction _service

    private WorkOrderStateAction getService() {
        if(!_service)
            _service = Holders.applicationContext.getBean(serviceName)
        _service
    }

    @Override
    WorkOrderState next(String workflowId, WorkOrder item) {
        service.next(workflowId, item)
    }

    @Override
    WorkOrderState save(String workflowId, WorkOrder item) {
        service.save(workflowId, item)
    }

    @Override
    WorkOrderState back(String workflowId, WorkOrder item) {
        service.back(workflowId, item)
    }
}
