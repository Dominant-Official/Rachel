//below code is to make a phone call.

//getting list of contacts
Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);

  while (cursor.moveToNext()) {

	   String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
	   String phone = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

	   {

		  HashMap<String, Object> _item = new HashMap<>();

	      _item.put("name", name);

          _item.put("phone", phone);

		  contacts.add(_item);

	   }

  }
int n = 0;

Boolean notC = false;
String contact = "Contact name";

for(int _repeat12 = 0; _repeat12 < (int)(contacts.size()); _repeat12++) {

	if (contacts.get((int)n).get("name").toString().toLowerCase().equals(contact)) {
		notC = false;

		Intent sendIntent = new Intent();

		sendIntent.setAction(Intent.ACTION_CALL);

		sendIntent.setData(Uri.parse("tel:" + contacts.get((int)n).get("phone").toString()));

		startActivity(sendIntent);


		break;

	}

	else {

		n++;

		aggCmdOn = true;

		notC = true;

	}

}

n = 0;

if (notC) {

	SketchwareUtil.showMessage(getApplicationContext(), "No contact exists");

}
