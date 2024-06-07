# ThanksApp

This Android application facilitates connections between blood donors and recipients. A nurse acts as a mediator to manage donor and recipient information via the app. The app generates QR codes for donors, which can be scanned by recipients to send a thank you message to the donor.

## Features

- **Login System**: Secure login for authorized nurses.
- **Donor Section**: Enter donor details and generate a unique QR code.
- **Recipient Section**: Scan QR code and send a thank you message to the donor.
- **QR Code Generation**: Create QR codes based on donor information.
- **Save QR Code**: Download the generated QR code to the device's gallery.

## Prerequisites

- Android Studio
- Android device or emulator with Android 6.0 (API level 23) or higher

## Getting Started

### Setup

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/blood-donation-app.git
    ```
2. Open the project in Android Studio.
3. Ensure you have the required dependencies and permissions in your `build.gradle` and `AndroidManifest.xml`.

### Dependencies

Add the following dependencies in your `build.gradle` file:

```gradle
dependencies {
    implementation 'com.journeyapps:zxing-android-embedded:4.2.0'
    implementation 'com.google.zxing:core:3.4.1'
}
```
Permissions
Add the necessary permissions in your AndroidManifest.xml file:

````
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.CAMERA"/>
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
<uses-permission android:name="android.permission.SEND_SMS"/>
<uses-permission android:name="android.permission.RECEIVE_SMS"/>
````
### Project Structure

**MainActivity.java:** Redirects to LoginActivity if not logged in.
**LoginActivity.java:** Handles user login.
**DonorActivity.java:** Handles donor information input and QR code generation.
**ReceiverActivity.java:** Handles QR code scanning and sending thank you messages.
**DatabaseHelper.java:** Manages SQLite database for storing login credentials.

### Implementation
**LoginActivity.java:**
Handles user login and validation against stored credentials.

**DonorActivity.java:**
Input donor name and mobile number.
Generate QR code based on input.
Show download button after QR code is generated.
Save QR code to device gallery.

**ReceiverActivity.java:**
Scan QR code to retrieve donor information.
Send a thank you message to the donor's mobile number.

**DatabaseHelper.java:**
Manages SQLite database operations for storing and retrieving user credentials.

### App Screenshots
Use the default usetname nad password to login to the app.

**username: nurse1**
**password: password123**

![Screenshot 2024-06-07 105648](https://github.com/Nandini0387/ThanksApp/assets/137043974/6b2d154f-88b6-4bc5-902b-43d6a25cc252)



