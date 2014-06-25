package com.hida.imms.workorder

import grails.transaction.Transactional

/**
 * engineer to rework a rejected-work-order or cancel it.
 */
@Transactional
class ManagerRejectedActionService implements WorkOrderStateAction {

    @Override
    WorkOrderState next(String workflowId, WorkOrder item) {
        item.save(failOnError: true)
        return WorkOrderState.ENGINEER_DRAFT
    }

    @Override
    WorkOrderState save(String workflowId, WorkOrder item) {
        item.save(failOnError: true)
        WorkOrderState.MANAGER_REJECTED
    }

    @Override
    WorkOrderState back(String workflowId, WorkOrder item) {
        return WorkOrderState.ENGINEER_DRAFT.back(workflowId, item)
    }
}

