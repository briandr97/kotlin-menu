package menu.domain

import camp.nextstep.edu.missionutils.Randoms
import menu.common.Category

private const val RANGE_START = 1
private const val RANGE_END = 5
private const val CATEGORY_ERROR = "카테고리 선택에서 예상치 못한 오류가 발생했습니다."

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): Category {
        val randomNumber = Randoms.pickNumberInRange(RANGE_START, RANGE_END)
        return Category.values().find { it.order == randomNumber } ?: throw IllegalArgumentException(CATEGORY_ERROR)
    }
}
