package com.hida.imms.workorder

import com.hida.imms.UnsupportedStatusTransitionException
import grails.transaction.Transactional

@Transactional
class WorkInterruptedActionService implements WorkOrderStateAction {

    @Override
    WorkOrderState next(String workflowId, WorkOrder item) {
        item.save(failOnError: true)
        return WorkOrderState.WORK_IN_PROGRESS
    }

    @Override
    WorkOrderState save(String workflowId, WorkOrder item) {
        throw new UnsupportedStatusTransitionException()
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