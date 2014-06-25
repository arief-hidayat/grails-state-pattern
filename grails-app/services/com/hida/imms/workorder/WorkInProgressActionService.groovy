package com.hida.imms.workorder

import grails.transaction.Transactional

/**
 * engineer in
 */
@Transactional
class WorkInProgressActionService implements WorkOrderStateAction {

    @Override
    WorkOrderState next(String workflowId, WorkOrder item) {
        item.save(failOnError: true)
        return WorkOrderState.WORK_COMPLETED
    }

    @Override
    WorkOrderState save(String workflowId, WorkOrder item) {
        item.save(failOnError: true)
        boolean isInterruption = true
        isInterruption? WorkOrderState.WORK_INTERRUPTED : WorkOrderState.WORK_IN_PROGRESS
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