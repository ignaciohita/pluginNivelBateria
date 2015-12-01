package pro.hita.nivelBateria;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NivelBateria extends CordovaPlugin {
    public NivelBateria() {
    }

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        if (action.equals("obtenerNivelBateria")) {
            Intent batteryIntent = cordova.getActivity().getApplicationContext().registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
            int level = batteryIntent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = batteryIntent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

            try{
                JSONObject objetoRetorno = new JSONObject();
                objetoRetorno.put("nivelBateria", new Float(((float)level / (float)scale) * 100.0f).toString());
                callbackContext.success(objetoRetorno);
            } catch (JSONException jse){
                return false;
            }

            return true;
        }else{
            return false;
        }
    }
}
