package com.hida.imms.workorder

import com.hida.imms.ActionInfo
import com.hida.imms.UnsupportedStatusTransitionException
import grails.transaction.Transactional

@Transactional
class WorkClosedActionService implements WorkOrderStateAction {
    @Override
    WorkOrderState next(WorkOrder item, ActionInfo actionInfo) {
        throw new UnsupportedStatusTransitionException()
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