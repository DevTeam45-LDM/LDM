package com.devteam45ldm.ldm.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.server.menu.MenuConfiguration;
import com.vaadin.flow.server.menu.MenuEntry;
import com.vaadin.flow.theme.lumo.LumoUtility;
import java.util.List;

/**
 * The {@code MainLayout} class represents the main layout of the application.
 * It serves as a top-level placeholder for other views, managing a navigation drawer,
 * a header, and footer components.
 */
@Layout
@AnonymousAllowed
public class MainLayout extends AppLayout {

    /**
     * The title of the current view, displayed in the header.
     */
    private H1 viewTitle;

    /**
     * Constructs the {@code MainLayout} by setting up the primary layout sections and content.
     */
    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    /**
     * Adds content to the application header, including the menu toggle button and view title.
     */
    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H1();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }

    /**
     * Adds content to the drawer, including the application name, navigation, and footer.
     */
    private void addDrawerContent() {
        Span appName = new Span("LDM");
        appName.addClassNames(LumoUtility.FontWeight.SEMIBOLD, LumoUtility.FontSize.LARGE);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }

    /**
     * Creates the navigation menu using {@link MenuConfiguration}.
     *
     * @return a {@link SideNav} component populated with menu entries.
     */
    private SideNav createNavigation() {
        SideNav nav = new SideNav();

        List<MenuEntry> menuEntries = MenuConfiguration.getMenuEntries();
        menuEntries.forEach(entry -> {
            if (entry.icon() != null) {
                nav.addItem(new SideNavItem(entry.title(), entry.path(), new SvgIcon(entry.icon())));
            } else {
                nav.addItem(new SideNavItem(entry.title(), entry.path()));
            }
        });

        return nav;
    }

    /**
     * Creates the footer component for the drawer.
     *
     * @return a {@link Footer} component.
     */
    private Footer createFooter() {
        Footer layout = new Footer();
        return layout;
    }

    /**
     * Updates the view title after navigation to reflect the title of the current page.
     */
    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    /**
     * Retrieves the title of the current page from {@link MenuConfiguration}.
     *
     * @return the title of the current page, or an empty string if not available.
     */
    private String getCurrentPageTitle() {
        return MenuConfiguration.getPageHeader(getContent()).orElse("");
    }
}
