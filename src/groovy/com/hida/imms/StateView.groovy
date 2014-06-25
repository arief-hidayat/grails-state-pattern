package com.hida.imms

/**
 * Created by arief.hidayat on 25/06/2014.
 */
interface StateView<T> {
    List<ActionView> getView(T item, String ActionInfo)
}
