package com.hida.imms.workorder

import org.joda.time.LocalDateTime

class WorkOrderCancellation {
    long workOrderId
    String workOrderNm
    String workOrderState
    String cancelledBy
    String reasons
    LocalDateTime cancelledAt

    static constraints = {
        workOrderId unique : true
    }
}
