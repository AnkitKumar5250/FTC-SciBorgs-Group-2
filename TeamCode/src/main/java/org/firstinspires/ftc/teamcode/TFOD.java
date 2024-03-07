package org.firstinspires.ftc.teamcode;

import android.content.Context;
import android.graphics.Bitmap;

import org.firstinspires.ftc.teamcode.ml.ModelUnquant;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class TFOD {
    // public void analyze(Bitmap image, Context context) {
    //     try {
    //         ModelUnquant model = ModelUnquant.newInstance(context);
    //         // Creates inputs for reference.
    //         TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 224, 224, 3}, DataType.FLOAT32);
    //         // Creating Byte Buffer
    //         ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4 * image_height * image_width * 3);
    //         byteBuffer.order(ByteOrder.nativeOrder());
    //         int[] intValues = new int[image_width*image_height];
    //         image.getPixels(intValues,0,image.getWidth(),0,0,image.getWidth(),image.getHeight());
    //         int pixel = 0;
    //         for (int i = 0;i < image_width; i++) {
    //             for (int j = 0;j < image_height; j++) {                
    //             }
    //         }
    //         // loading buffer into model
    //         inputFeature0.loadBuffer(byteBuffer);
    //         // Runs model inference and gets result.
    //         ModelUnquant.Outputs outputs = model.process(inputFeature0);
    //         TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();
    //         // Releases model resources if no longer used.
    //         model.close();
    //     } catch (IOException e) {
    //         // TODO Handle the exception
    //     }
    // }

    public void analyze() {
        
    }
}
