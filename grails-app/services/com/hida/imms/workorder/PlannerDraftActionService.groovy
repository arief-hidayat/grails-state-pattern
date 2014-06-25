package com.hida.imms.workorder

import com.hida.imms.ActionInfo
import grails.transaction.Transactional

/**
 * engineer to complete draft and send for approval
 */
@Transactional
class PlannerDraftActionService implements WorkOrderStateAction {
    @Override
    WorkOrderState next(WorkOrder item, ActionInfo actionInfo) {
        item.save(failOnError: true)
        return WorkOrderState.ENGINEER_DRAFT
    }

    @Override
    WorkOrderState save(WorkOrder item, ActionInfo actionInfo) {
        item.save(failOnError: true)
        return WorkOrderState.PLANNER_DRAFT
    }

    @Override
    WorkOrderState back(WorkOrder item, ActionInfo actionInfo) {
        //rollback what's done in WorkOrderState.NEW.next
        return WorkOrderState.NEW.back(item, actionInfo)
    }
}
