#include <stdio.h>
#include <map>


using namespace std;

int main(){
int cases;
scanf("%d", &cases);

for(int i=1;i<=cases;i++){
int nOfFriends;
scanf("%d", &nOfFriends);
map <int, int> friends;
map<int, int> stamps;
for(int j=0;j<nOfFriends;j++){
int numFriendAct;
scanf("%d", &numFriendsAct);

for(int k=0;k<numFriendsAct;k++){
int stampAct;
scanf("%d", &stampAct);
if(stamps.count(stampAct==0){

stamps.insert(pair<int,int>(stampAct,stamps.get(stampAct)));
}else{
stamps.insert(pair<int,int>(stampAct,1));
}


}


printf("Case %d: ", i);
}


return 0;
}
