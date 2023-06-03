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
