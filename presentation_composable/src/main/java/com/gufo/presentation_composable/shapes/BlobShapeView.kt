package com.gufo.presentation_composable.shapes

import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.text.TextLayoutInput
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun BlobShapeView(
    color: Color,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier) {

        val blobPath = Path().apply {
            moveTo(size.width * 0.2f, size.height * 0.4f)
            cubicTo(
                size.width * 0.1f, size.height * 0.1f,
                size.width * 0.8f, size.height * 0.1f,
                size.width * 0.9f, size.height * 0.5f
            )
            cubicTo(
                size.width * 0.9f, size.height * 0.9f,
                size.width * 0.2f, size.height * 0.8f,
                size.width * 0.2f, size.height * 0.4f
            )

            cubicTo(
                size.width * 0.95f, size.height * 0.95f,
                size.width * 0.2f, size.height * 0.8f,
                size.width * 0.2f, size.height * 0.4f
            )
            close()

            close()
        }
        drawPath(blobPath, Color.Black,)

    }

}


@Preview
@Composable
fun PreviewBlobShapeView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        contentAlignment = Alignment.Center,
    ) {
        BlobShapeView(color = Color.Red, modifier = Modifier.size(200.dp))
    }
}
