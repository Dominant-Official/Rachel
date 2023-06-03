//below code shows how Wikipedia result can be used for a specific query.
private RequestNetwork req;

private RequestNetwork.RequestListener _req_request_listener;

  

String query = "Your query"; 

req.startRequestNetwork(RequestNetworkController.GET, "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles="+query, "A", _req_request_listener);

_req_request_listener = new RequestNetwork.RequestListener() {

			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {

				final String _tag = _param1;

				final String _response = _param2;

				final HashMap<String, Object> _responseHeaders = _param3;

				

					String sr = _response.substring((int)(_response.indexOf("t\":\"")), (int)(_response.length() - 5));

					String s = sr.substring((int)(4), (int)(sr.length()));

					final String responseText = s.replaceAll("\\\\n", "\n");

					String txt = responseText;

					Pattern pattern = Pattern.compile("\\\\u(\\p{XDigit}{4})"); // Create a matcher object that searches for the pattern in the string 

					Matcher matcher = pattern.matcher(txt);

					while (matcher.find()) {

						    // Get the matched Unicode character

						    String unicodeStr = matcher.group();

						

						    // Convert the Unicode string to its corresponding symbol

						    String symbol = Character.toString((char) Integer.parseInt(unicodeStr.substring(2), 16));

						

						    // Replace the Unicode character with its corresponding symbol

						    String final_result = symbol.replace(unicodeStr, symbol);

					}

                

            }

   }

