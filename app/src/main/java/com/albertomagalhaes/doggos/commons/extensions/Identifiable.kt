package com.albertomagalhaes.doggos.commons.extensions

/**
 * Instance of identifiable with equals [id] means that they are conceptually the same, even if
 * other properties are different
 */
interface Identifiable<T> {

    /**
     * Used to identify different entities. It is typically a [String] or an [Int]
     */
    val id: T
}