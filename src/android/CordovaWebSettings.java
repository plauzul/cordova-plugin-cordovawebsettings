package cordova.plugin.cordovawebsettings;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

import org.apache.cordova.engine.SystemWebView;
import android.webkit.WebSettings;

/**
 * This class echoes a string called from JavaScript.
 */
public class CordovaWebSettings extends CordovaPlugin {

    WebSettings settings;

    @Override
    protected void pluginInitialize() {
        super.pluginInitialize();
        SystemWebView appView = (SystemWebView) this.webView.getEngine().getView();
        this.settings = appView.getSettings();
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("setAllowFileAccess")) {
            Boolean status = args.getBoolean(0);
            this.setAllowFileAccess(status, callbackContext);
            return true;
        } else if (action.equals("setAllowFileAccessFromFileURLs")) {
            Boolean status = args.getBoolean(0);
            this.setAllowFileAccessFromFileURLs(status, callbackContext);
            return true;
        } else if (action.equals("setAllowUniversalAccessFromFileURLs")) {
            Boolean status = args.getBoolean(0);
            this.setAllowUniversalAccessFromFileURLs(status, callbackContext);
            return true;
        }
        return false;
    }

    private void setAllowFileAccess(Boolean status, CallbackContext callbackContext) {
        if (status != null) {
            this.settings.setAllowFileAccess(status);
            callbackContext.success();
        } else {
            callbackContext.error("Expected one non-empty Boolean argument.");
        }
    }

    private void setAllowFileAccessFromFileURLs(Boolean status, CallbackContext callbackContext) {
        if (status != null) {
            this.settings.setAllowFileAccessFromFileURLs(status);
            callbackContext.success();
        } else {
            callbackContext.error("Expected one non-empty Boolean argument.");
        }
    }

    private void setAllowUniversalAccessFromFileURLs(Boolean status, CallbackContext callbackContext) {
        if (status != null) {
            this.settings.setAllowUniversalAccessFromFileURLs(status);
            callbackContext.success();
        } else {
            callbackContext.error("Expected one non-empty Boolean argument.");
        }
    }
}
