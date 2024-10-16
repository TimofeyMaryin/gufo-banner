package com.gufo.data

import android.graphics.Color
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Banner(
    val width: Int = 1920,
    val height: Int = 1080,
    val backgroundImageRes: Int, // Ресурс изображения для фона
    val abstractShape: AbstractShape, // Настройки абстрактной формы
    val overlayImageRes: Int, // Ресурс изображения для наложенного изображения
    val text: BannerText, // Текст на баннере
    val darkenOverlay: Float // Уровень затемнения от 0f (нет затемнения) до 1f (полное затемнение)
)

data class AbstractShape(
    val color: Color, // Цвет абстрактной формы
    val shapeType: ShapeType, // Тип формы (например, Blob, Wave, Custom)
    val cornerRadius: Dp = 0.dp, // Радиус скругления углов для прямоугольных форм
    val padding: PaddingValues = PaddingValues(0.dp) // Отступы формы внутри баннера
)

enum class ShapeType {
    BLOB, // Неправильная форма, похожая на blob
    WAVE, // Волнообразная форма
    CIRCLE, // Круг
    RECTANGLE // Прямоугольник с возможностью скругления углов
}

data class BannerText(
    val content: String, // Текст, который отображается на баннере
    val fontSize: Float, // Размер шрифта
    val textColor: Color, // Цвет текста
    val positionX: Float, // Позиция X текста на баннере
    val positionY: Float, // Позиция Y текста на баннере
    val maxWidth: Float // Максимальная ширина текста
)
