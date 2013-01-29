#!/bin/sh

HOST="nyx.unice.fr"
BASEDIR="/nasrainbow/www/www-nossl/p2/sigma"

if [ $# -ne 1 ]; then
	echo "Usage: $0 <dir>"
	echo 
	echo "The dir should be either:"
	echo "  latest for a nightly build"
	echo "  milestones/<name> for a milestone"
	echo "  releases/<name> for a release"
	echo 
	echo "Existing:"
	ssh $HOST "ls -1 $BASEDIR/{milestones,releases}" 

	exit 1
fi

source="fr.unice.i3s.sigma.site/target/repository/"
target="$BASEDIR/$1"

echo "Uploading $source to $HOST:$target:"

echo "1. creating temp dir"
tmp=$(ssh $HOST "mktemp -d")

echo "2. copying to temp: $HOST:$tmp"
rsync -av $source/ $HOST:$tmp

echo "3. sync changes"
ssh -t $HOST "sudo -u www-data rsync -a $tmp/ $target"

echo "4. remove the temp: $tmp"
ssh $HOST "rm -fr $tmp"
