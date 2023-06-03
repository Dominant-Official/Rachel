//below code is use to open a app from list of installed applications.
public ArrayList<HashMap<String, Object>> getApplicationList (final String _app_name, final String _package_name) {

				{						android.content.pm.PackageManager pm = myContext.getPackageManager();

						     HashMap<String, Object> Map = new HashMap<>();

							 ArrayList<HashMap<String, Object>> map = new ArrayList<>();

						    Intent intent = new Intent(Intent.ACTION_MAIN, null);

						    intent.addCategory(Intent.CATEGORY_LAUNCHER);

						    List<android.content.pm.ResolveInfo> PackList = pm.queryIntentActivities(intent, android.content.pm.PackageManager.PERMISSION_GRANTED);

						    for (android.content.pm.ResolveInfo rInfo : PackList) {

								

								        String AppName = rInfo.activityInfo.applicationInfo.loadLabel(pm).toString();

								        String PackageName = rInfo.activityInfo.applicationInfo.packageName;

								Map = new HashMap<>();

								Map.put(_app_name, AppName);

								Map.put(_package_name, PackageName);

								map.add(Map);

								        }

						        return map;

						        }

		}

