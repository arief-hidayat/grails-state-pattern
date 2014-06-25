package com.hida.imms.workorder

import grails.transaction.Transactional

/**
 * Planner see this either from auto-generated or manual creation.
 */
@Transactional
class NewActionService implements WorkOrderStateAction {

    @Override
    WorkOrderState next(String workflowId, WorkOrder item) {
        item.save(failOnError: true)
        return WorkOrderState.PLANNER_DRAFT
    }

    @Override
    WorkOrderState save(String workflowId, WorkOrder item) {
        item.save(failOnError: true)
        return WorkOrderState.NEW
    }

    @Override
    WorkOrderState back(String workflowId, WorkOrder item) {
        // delete workflow record
        // delete work order
        // create work cancellation record and the reason.
        item.delete()
        return WorkOrderState.WORK_CANCELLED
    }
}
