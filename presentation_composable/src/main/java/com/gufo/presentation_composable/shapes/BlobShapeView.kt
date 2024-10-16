package com.gufo.presentation_composable.shapes

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


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

            close()
        }
        drawPath(blobPath, color,)

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
        BlobShapeView(color = Color.Red, modifier = Modifier.fillMaxWidth(.9f).height(400.dp))
    }
}
