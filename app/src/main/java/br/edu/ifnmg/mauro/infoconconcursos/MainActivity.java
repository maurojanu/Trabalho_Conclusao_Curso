package br.edu.ifnmg.mauro.infoconconcursos;

import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;



public class MainActivity extends ActionBarActivity {
    private FragmentNavigationDrawer dlDrawer;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Find our drawer view
        dlDrawer = (FragmentNavigationDrawer) findViewById(R.id.drawer_layout);
        // Setup drawer view
        dlDrawer.setupDrawerConfiguration((ListView) findViewById(R.id.lvDrawer), toolbar,
                R.layout.drawer_nav_item, R.id.flContent);
        // Add nav items
        dlDrawer.addNavItem("Concursos onde estou", R.drawable.abc_btn_check_to_on_mtrl_000, "Concursos onde estou", ConcursoOndeEstou.class);
        dlDrawer.addNavItem("Todos os concursos", R.drawable.abc_btn_check_to_on_mtrl_000, "Todos os concursos", TodosConcursos.class);
        dlDrawer.addNavItem("Concursos por estado", R.drawable.abc_btn_check_to_on_mtrl_000, "Concursos por estado", ConcursosEstado.class);
        dlDrawer.addNavItem("Concursos por região", R.drawable.abc_btn_check_to_on_mtrl_000, "Concursos por região", ConcursoRegiao.class);
        dlDrawer.addNavItem("Minhas visualizações", 1, "Minhas visualizações", MinhasVisualizacoes.class);
        dlDrawer.addNavItem("Arquivos", 1, "Arquivos", Arquivos.class);
        dlDrawer.addNavItem("Configurações", 1, "Configuraçoes", Configuracao.class);
        // Select default
        if (savedInstanceState == null) {
            dlDrawer.selectDrawerItem(0);
        }
    }

    private void setSupportActionBar() {
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content
        if (dlDrawer.isDrawerOpen()) {
            // Uncomment to hide menu items
            // menu.findItem(R.id.mi_test).setVisible(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        // Uncomment to inflate menu items to Action Bar
        // inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (dlDrawer.getDrawerToggle().onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        dlDrawer.getDrawerToggle().syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        dlDrawer.getDrawerToggle().onConfigurationChanged(newConfig);
    }
}