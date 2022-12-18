package menu.domain

import menu.common.Category

interface NumberGenerator {
    fun generate(): Category
}
