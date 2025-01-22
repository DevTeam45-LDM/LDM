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
  if (key === '0bc7e55ca2aa195721ec2b72ff65b20dc50caf3ad2041f78e5a792f1b4ad1452') {
    pending.push(import('./chunks/chunk-77abc7e694150f4ce34afc7ccf9138663cf6b0c8e0c971f96a58b7ad8f3e16b2.js'));
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