package com.hida.imms.workorder

import com.hida.imms.ActionInfo
import com.hida.imms.StateAction
import com.hida.imms.UnsupportedStatusTransitionException
import grails.transaction.Transactional

@Transactional
class WorkInterruptedActionService implements StateAction<WorkOrder> {

    @Override
    WorkOrderState next(WorkOrder item, ActionInfo actionInfo) {
        item.save(failOnError: true)
        return WorkOrderState.WORK_IN_PROGRESS
    }

    @Override
    WorkOrderState save(WorkOrder item, ActionInfo actionInfo) {
        throw new UnsupportedStatusTransitionException()
    }

    @Override
    WorkOrderState back(WorkOrder item, ActionInfo actionInfo) {
        throw new UnsupportedStatusTransitionException()
    }
}