import { injectGlobalWebcomponentCss } from 'Frontend/generated/jar-resources/theme-util.js';

import '@vaadin/polymer-legacy-adapter/style-modules.js';
import '@vaadin/text-field/src/vaadin-text-field.js';
import '@vaadin/tooltip/src/vaadin-tooltip.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/button/src/vaadin-button.js';
import 'Frontend/generated/jar-resources/buttonFunctions.js';
import '@vaadin/notification/src/vaadin-notification.js';
import 'Frontend/generated/jar-resources/flow-component-renderer.js';
import '@vaadin/app-layout/src/vaadin-drawer-toggle.js';
import '@vaadin/side-nav/src/vaadin-side-nav.js';
import '@vaadin/icon/src/vaadin-icon.js';
import '@vaadin/side-nav/src/vaadin-side-nav-item.js';
import '@vaadin/scroller/src/vaadin-scroller.js';
import '@vaadin/app-layout/src/vaadin-app-layout.js';
import '@vaadin/common-frontend/ConnectionIndicator.js';
import '@vaadin/vaadin-lumo-styles/sizing.js';
import '@vaadin/vaadin-lumo-styles/spacing.js';
import '@vaadin/vaadin-lumo-styles/style.js';
import '@vaadin/vaadin-lumo-styles/vaadin-iconset.js';
import 'Frontend/generated/jar-resources/ReactRouterOutletElement.tsx';

const loadOnDemand = (key) => {
  const pending = [];
  if (key === '87b6d2669034128f75863a889035c0c5219a8495e1cb0efab65ac531266d6f9b') {
    pending.push(import('./chunks/chunk-be861dcccf6725f93341bba1b4f65e3534fa03ed337c14bc3fdaf922e8420563.js'));
  }
  if (key === '90ee41a6791bd5f0789a2c6f37ed7d943a0522af966a81883e2e75262eab4492') {
    pending.push(import('./chunks/chunk-23cffbd2746b70015b8480f58b76381fc8638257a1aa29f64b5e817df13854b3.js'));
  }
  if (key === '961ac858476cabe7607613df4c4212afd1d09368f578f0b347f0f2e8adab4dbf') {
    pending.push(import('./chunks/chunk-ec3b540e674523488a9eb1bcba81a1595ea541b95d721a7eef7db6f0a770223b.js'));
  }
  if (key === '9d0d2d25a9c60ed931e08a49d156058f94bf7c2a135bdb1d5f1b74cb201f2d04') {
    pending.push(import('./chunks/chunk-7935210d1cc52089193cfae445d5ec93f0cc1a791f2df0b5aedf93d600186cea.js'));
  }
  if (key === 'e9fbeab5177a462a6c00cab486e546b62fc20a32272d27ee127867f8f354bdf7') {
    pending.push(import('./chunks/chunk-be861dcccf6725f93341bba1b4f65e3534fa03ed337c14bc3fdaf922e8420563.js'));
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