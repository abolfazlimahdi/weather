package abolfazli.mahdi.weather.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ViewUtils {

   public enum IconSize {
      SMALL("@2x.png"), MEDIUM("@4x.png");
      private final String iconSize;

      private IconSize(String iconSize)
      {
         this.iconSize = iconSize;
      }

      public String getIconSize()
      {
         return this.iconSize;
      }


   }
   public static void loadWeatherIcons(ImageView imageView, String iconName, IconSize iconSize) {
      String iconUrl = "https://openweathermap.org/img/wn/" + iconName + iconSize.getIconSize();
      ExecutorService executor = Executors.newSingleThreadExecutor();
      Handler handler = new Handler(Looper.getMainLooper());

      executor.execute(() -> {
         try {
            InputStream in = new URL(iconUrl).openStream();
            Bitmap bitmap = BitmapFactory.decodeStream(in);
            handler.post(() -> {
               imageView.setImageBitmap(bitmap);
            });
         } catch (Exception e) {
            Log.e("Exception", e.toString());
         }
      });
   }

   public static void loadImage(ImageView imageView, String imageUrl) {

      ExecutorService executor = Executors.newSingleThreadExecutor();
      Handler handler = new Handler(Looper.getMainLooper());

      executor.execute(() -> {
         try {
            InputStream in = new URL(imageUrl).openStream();
            Bitmap bitmap = BitmapFactory.decodeStream(in);
            handler.post(() -> {
               imageView.setImageBitmap(bitmap);
            });
         } catch (Exception e) {
            Log.e("Exception", e.toString());
         }
      });
   }


}
