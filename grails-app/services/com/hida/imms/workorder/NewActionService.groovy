package com.hida.imms.workorder

import com.hida.imms.ActionInfo
import com.hida.imms.StateAction
import grails.transaction.Transactional
import org.joda.time.LocalDateTime

/**
 * Planner see this either from auto-generated or manual creation.
 */
@Transactional
class NewActionService implements StateAction<WorkOrder> {

    @Override
    WorkOrderState next(WorkOrder item, ActionInfo actionInfo) {
        item.save(failOnError: true)
        return WorkOrderState.PLANNER_DRAFT
    }

    @Override
    WorkOrderState save(WorkOrder item, ActionInfo actionInfo) {
        item.save(failOnError: true)
        return WorkOrderState.NEW
    }

    @Override
    @Transactional
    WorkOrderState back(WorkOrder item, ActionInfo actionInfo) {
        // delete workflow record
        // delete work order
        // create work cancellation record and the reason.
        new WorkOrderCancellation(workOrderId: item.id, workOrderNm: item.workOrderNm, workOrderState: item.state,
                cancelledBy: actionInfo.userId, cancelledAt: actionInfo.time ?: LocalDateTime.now(), reasons: actionInfo.reason).
        save(failOnError: true)

        item.delete()
        return WorkOrderState.WORK_CANCELLED
    }
}
