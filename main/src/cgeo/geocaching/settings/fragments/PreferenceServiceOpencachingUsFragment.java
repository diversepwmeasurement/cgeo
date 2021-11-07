package cgeo.geocaching.settings.fragments;

import cgeo.geocaching.R;
import cgeo.geocaching.settings.OCPreferenceKeys;
import cgeo.geocaching.utils.ShareUtils;

import android.os.Bundle;

import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import org.apache.commons.lang3.StringUtils;

public class PreferenceServiceOpencachingUsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences_services_opencaching_us, rootKey);

        // Open website Preference
        Preference openWebsite = findPreference(getString(R.string.pref_fakekey_ocus_website));
        String urlOrHost = OCPreferenceKeys.OC_US.authParams.host;
        openWebsite.setOnPreferenceClickListener(preference -> {
            final String url = StringUtils.startsWith(urlOrHost, "http") ? urlOrHost : "http://" + urlOrHost;
            ShareUtils.openUrl(getContext(), url);
            return true;
        });
    }
}
