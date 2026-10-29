<!--
SPDX-FileCopyrightText: Saalim Quadri <danascape@gmail.com>
SPDX-License-Identifier: Apache-2.0
-->

# Privacy Policy — Calculator

_Effective 30 October 2026_

Calculator (package `org.prauga.calculator`) is a calculator app published by Saalim Quadri for
PVOT-OSS. This policy explains what the app does with your data.

**In short: the app doesn't collect, send, share or sell any personal data. It has no accounts, no
ads, no analytics and no tracking, and it has no permission to use the internet.**

## What the app keeps on your device

- **Your calculation history**: the expressions you evaluated and their results, so you can see
  and reuse them in the History view. Clear it at any time with **Clear** in the History view.
- **Settings**: degrees or radians, the value in memory, and which result you last copied (so the
  app can recognise it when you paste it back).

All of this stays in the app's private storage and is deleted when you clear the app's storage or
uninstall it.

## Backups

If you turn on Android's device backup, Android may include the app's history and settings in your
device backup (for example, Google's backup on most devices), under the terms of that backup
service. The app itself never sends them anywhere. You can turn backup off in your device's
settings.

## The clipboard

When you copy an expression or result, the app puts it on the clipboard. While the app is on
screen, it checks whether the clipboard holds text so it can offer **Paste**, and it reads the
clipboard's text when you choose **Paste**. Clipboard contents are never stored or sent anywhere.

## Permissions

The app requests no permissions. The only one listed in the app,
`org.prauga.calculator.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION`, is added by the AndroidX library
to keep the app's internal broadcasts private; it gives the app no access to your data.

The app does not have the `INTERNET` permission. The open source licenses screen is shown from a
page bundled in the app.

## Children

The app is not directed at children and collects no data from anyone, children included.

## Changes

If the app starts handling data differently, this policy will be updated before that version is
released, with a new effective date at the top.

## Contact

Questions about this policy: danascape@gmail.com, or open an issue at
https://github.com/PVOT-OSS/PvotCalculator/issues.
