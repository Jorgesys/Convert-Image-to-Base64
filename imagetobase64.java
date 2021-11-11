
    private static final String BASE = "data:image/png;base64,";
    private String imagetoBase64 = "";
    private void convertImagetoBase64(){

    //* Example: http://jaredwinick.github.io/base64-image-viewer/
        
        bitmap = BitmapFactory.decodeResource(getResources(), R.raw.githubmascot);

        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
                byte[] byteFormat = stream.toByteArray();
                // Get the Base64 string
                String imgString = Base64.encodeToString(byteFormat, Base64.NO_WRAP);
                return imgString;
            }

            @Override
            protected void onPostExecute(String s) {
                imagetoBase64 = BASE + s;
                editText.setText(BASE + s);
                Log.i(TAG, "ImagetoBase64 : " +BASE + s);
            }
        }.execute();
    }

