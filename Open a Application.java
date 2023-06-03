//below code is use to open a app from list of installed applications.

//getting apps in a ArrayList

public void appList() {{

        PackageManager pm = myContext.getPackageManager();

	    HashMap<String, Object> Map = new HashMap<>();
		ArrayList<HashMap<String, Object>> map = new ArrayList<>();

        

		Intent intent = new Intent(Intent.ACTION_MAIN, null);

		intent.addCategory(Intent.CATEGORY_LAUNCHER);

	    List<ResolveInfo> PackList = pm.queryIntentActivities(intent,android.content.pm.PackageManager.PERMISSION_GRANTED);

           

           for (ResolveInfo rInfo : PackList) {

	               String AppName = rInfo.activityInfo.applicationInfo.loadLabel(pm).toString();

   			    String PackageName = rInfo.activityInfo.applicationInfo.packageName;

   				Map = new HashMap<>();

   				Map.put(app_name, AppName);

	   			Map.put(package_name, PackageName);

   				map.add(Map);

		    }

	   	        return map;     

        

	}

}

//now open app using a App name

int n = 0;

String app = "App name";

Boolean notApp = false;

for(int _repeat10 = 0; _repeat10 < (int)(map.size()); _repeat10++) {

	if (map.get((int)n).get("app_name").toString().toLowerCase().equals(app.toLowerCase())) {
		notApp = false;

		Intent sendIntent7 = new Intent();

		sendIntent7.setAction(Intent.ACTION_VIEW);

		sendIntent7 = getPackageManager().getLaunchIntentForPackage(map.get((int)n).get("package_name").toString());

		startActivity(sendIntent7);

		break;

	}

	else {

		n++;

		notApp = true;

	}

}

n = 0;

if (notApp) {

  showMessage(getApplicationContext(), "No app exists");

}
