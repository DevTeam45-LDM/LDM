import '@vaadin/tooltip/theme/lumo/vaadin-tooltip.js';
import '@vaadin/polymer-legacy-adapter/style-modules.js';
import '@vaadin/upload/theme/lumo/vaadin-upload.js';
import '@vaadin/button/theme/lumo/vaadin-button.js';
import 'Frontend/generated/jar-resources/buttonFunctions.js';
import '@vaadin/vertical-layout/theme/lumo/vaadin-vertical-layout.js';
import '@vaadin/app-layout/theme/lumo/vaadin-drawer-toggle.js';
import '@vaadin/side-nav/theme/lumo/vaadin-side-nav.js';
import '@vaadin/icon/theme/lumo/vaadin-icon.js';
import '@vaadin/side-nav/theme/lumo/vaadin-side-nav-item.js';
import '@vaadin/scroller/theme/lumo/vaadin-scroller.js';
import '@vaadin/app-layout/theme/lumo/vaadin-app-layout.js';
import '@vaadin/common-frontend/ConnectionIndicator.js';
import '@vaadin/vaadin-lumo-styles/color-global.js';
import '@vaadin/vaadin-lumo-styles/typography-global.js';
import '@vaadin/vaadin-lumo-styles/sizing.js';
import '@vaadin/vaadin-lumo-styles/spacing.js';
import '@vaadin/vaadin-lumo-styles/style.js';
import '@vaadin/vaadin-lumo-styles/vaadin-iconset.js';
import 'Frontend/generated/jar-resources/ReactRouterOutletElement.tsx';

const loadOnDemand = (key) => {
  const pending = [];
  if (key === '9d0d2d25a9c60ed931e08a49d156058f94bf7c2a135bdb1d5f1b74cb201f2d04') {
    pending.push(import('./chunks/chunk-84dd3d603e6eea4002a853c2efb8dc4a05ab3589f814004219376134e3fd5733.js'));
  }
  if (key === 'e9fbeab5177a462a6c00cab486e546b62fc20a32272d27ee127867f8f354bdf7') {
    pending.push(import('./chunks/chunk-e6d7f827972099d1e59b0a79d9f08c81c88f89a0e2dab6ca0a7be73b04ff9898.js'));
  }
  if (key === '51b0e3bab11863cdab654812dd44b7a419bc1e89d69d6869cd7f99b6d4b0339d') {
    pending.push(import('./chunks/chunk-10b70bcc6f0d536b1008cff259244afeb46184b0415eb92658b70eab36b957e6.js'));
  }
  if (key === '90ee41a6791bd5f0789a2c6f37ed7d943a0522af966a81883e2e75262eab4492') {
    pending.push(import('./chunks/chunk-e6975f74b4534a0b37d15adc14c9f024de579c7693567f9aec7b5d79df1771b3.js'));
  }
  if (key === '87b6d2669034128f75863a889035c0c5219a8495e1cb0efab65ac531266d6f9b') {
    pending.push(import('./chunks/chunk-e6d7f827972099d1e59b0a79d9f08c81c88f89a0e2dab6ca0a7be73b04ff9898.js'));
  }
  return Promise.all(pending);
}

window.Vaadin = window.Vaadin || {};
window.Vaadin.Flow = window.Vaadin.Flow || {};
window.Vaadin.Flow.loadOnDemand = loadOnDemand;
window.Vaadin.Flow.resetFocus = () => {
 let ae=document.activeElement;
 while(ae&&ae.shadowRoot) ae = ae.shadowRoot.activeElement;
 return !ae || ae.blur() || ae.focus() || true;
}