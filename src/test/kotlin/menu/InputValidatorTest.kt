package menu

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import menu.view.InputValidator
import menu.view.InputValidator.Companion.DUPLICATED_ERROR
import menu.view.InputValidator.Companion.MENU_COUNT_ERROR
import menu.view.InputValidator.Companion.NAME_COUNT_ERROR
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class InputValidatorTest {
    private val inputValidator = InputValidator()

    @Test
    fun `이름 중복 테스트`() {
        val names = listOf<String>("용민", "용민")
        assertSimpleTest {
            assertThatThrownBy {
                inputValidator.validateNames(names)
            }.isExactlyInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(DUPLICATED_ERROR)
        }
    }

    @Test
    fun `이름 개수 테스트`() {
        val names = listOf<String>("용민")
        assertSimpleTest {
            assertThatThrownBy {
                inputValidator.validateNames(names)
            }.isExactlyInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(NAME_COUNT_ERROR)
        }
    }

    @Test
    fun `메뉴 중복 테스트`() {
        val menus = listOf<String>("뇨끼", "뇨끼")
        assertSimpleTest {
            assertThatThrownBy {
                inputValidator.validateMenus(menus)
            }.isExactlyInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(DUPLICATED_ERROR)
        }
    }

    @Test
    fun `메뉴 개수 테스트`() {
        val menus = listOf<String>("뇨끼", "라자냐", "프렌치 토스트")
        assertSimpleTest {
            assertThatThrownBy {
                inputValidator.validateMenus(menus)
            }.isExactlyInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(MENU_COUNT_ERROR)
        }
    }
}
