package com.hida.imms.workorder

import com.hida.imms.UnsupportedStatusTransitionException
import grails.transaction.Transactional

/**
 * manager to approve or reject.
 *
 */
@Transactional
class EngineerDraftActionService implements WorkOrderStateAction {
    @Override
    WorkOrderState next(String workflowId, WorkOrder item) {
        boolean approved = true
        approved ? WorkOrderState.MANAGER_APPROVED : WorkOrderState.MANAGER_REJECTED
    }

    @Override
    WorkOrderState save(String workflowId, WorkOrder item) {
        throw new UnsupportedStatusTransitionException()
    }

    @Override
    WorkOrderState back(String workflowId, WorkOrder item) {
        return WorkOrderState.PLANNER_DRAFT.back(workflowId, item)
    }
}

