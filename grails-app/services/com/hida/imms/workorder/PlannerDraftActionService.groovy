package com.hida.imms.workorder

import grails.transaction.Transactional

/**
 * engineer to complete draft and send for approval
 */
@Transactional
class PlannerDraftActionService  implements WorkOrderStateAction {
    @Override
    WorkOrderState next(String workflowId, WorkOrder item) {
        item.save(failOnError: true)
        return WorkOrderState.ENGINEER_DRAFT
    }

    @Override
    WorkOrderState save(String workflowId, WorkOrder item) {
        item.save(failOnError: true)
        return WorkOrderState.PLANNER_DRAFT
    }

    @Override
    WorkOrderState back(String workflowId, WorkOrder item) {
        return WorkOrderState.NEW.back(workflowId, item)
    }
}
