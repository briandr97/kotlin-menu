package menu

import menu.common.Category
import menu.domain.CategoryCreator
import menu.domain.NumberGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

private const val CATEGORY_NOT_FOUND_ERROR = "카테고리를 찾지 못했습니다.(in TestRandomNumberGenerator)"

class CategoryCreatorTest {
    private val categoryCreator = CategoryCreator()

    @Test
    fun `카테고리 생성 테스트`() {
        val categories: List<Category> = categoryCreator.createCategories(TestRandomNumberGenerator())
        assertThat(categories).isEqualTo(Category.values().toList())
    }

    private class TestRandomNumberGenerator() : NumberGenerator {
        private var count: Int = 1

        override fun generate(): Category {
            val category = Category.values().find { it.order == count }
            count++
            return category ?: throw IllegalArgumentException(CATEGORY_NOT_FOUND_ERROR)
        }
    }
}
