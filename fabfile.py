#!/usr/bin/env python

### CONFIG


BASENAME = 'fr.unice.i3s.sigma'
RELENG = BASENAME + '.releng'
DEV_P2 = RELENG + ".p2"
SITE = BASENAME + '.site'

REMOTE = 'nyx.unice.fr'
REMOTE_P2 = '/nasrainbow/www/www-nossl/p2/sigma'

### CODE

from fabric.api import env, local, sudo, run
import os
import sys

env.hosts = [REMOTE]

def _mvn(args):
    return local('mvn %s' % args)

def clean():
    return _mvn('-f %s/pom.xml clean' % RELENG)

def build_dep():
    return _mvn('-f %s/pom.xml install' % DEV_P2)

def build():
    if not os.path.exists('%s/target/repository' % DEV_P2):
        if build_dep().failed:
            abort('Unable to build P2 site with external dependencies')

    return _mvn('-f %s/pom.xml install' % RELENG)

def p2latest():
    """
    Uploads the built P2 repository onto server in /latest
    """
    if not os.path.exists('%s/target/repository' % SITE):
        if build():
            abort('Unable to build project')

    target = REMOTE_P2 + '/latest'
    path = REMOTE + ':' + target

    # this has to be there in order to be able to replace the files
    username = run("whoami")
    if sudo("chown -R %s:%s %s" % (username, username, target)).failed:
        abort("Unable to set permission")

    if local("rsync -rvz --progress %s/target/repository/ %s" % (SITE, path)).failed:
        abort("Unable to transfer files to %s" % path)

    if sudo("chown -R www-data:www-data %s" % target).failed:
        abort("Unable to set permission")
