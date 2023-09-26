// 합병 정렬 코드 구현

import java.util.Arrays;
public class Main {
    public static void mergeSort(int[] arr, int[] tmp, int left, int right) { // 정렬하려는 배열 분할
        // int[] tmp : 합쳐가면서 정렬하는 것에 필요한 별도의 공간
        // left, right : 분할을 할 때 사용할 인덱스

        if(left<right){
            int mid = (left+right)/2; //배열에서 왼쪽보다 오른쪽이 더 크면 중앙값을 중앙에 있는 값으로 지정
            mergeSort(arr, tmp, left, mid); // 이렇게 써주면 왼쪽이랑 중앙값까지의 영역만 보게 된다. >> 전체 배열의 중앙값 기준 좌측 부분
            mergeSort(arr, tmp, mid+1, right); // 이렇게 해주면 중앙값+1과 오른쪽까지의 영역만 보게 된다. >> 전체 배열의 중앙값 기준 우측 부분
            // 위의 mergeSort들을 통해서 계속해서 분할 분할 분할 되는 것
            merge(arr, tmp, left, right, mid); // 가장 작은 단위부터 합병해가면서 제일 위로 올라온다.
        }
    }

    public static void merge(int[] arr, int[] tmp, int left, int right, int mid) { // 분할된 배열 합치기
        // 임시 인덱스 만들어 준다. p는 중앙값 기준 좌측의 인덱스이고, q는 중앙값 기준 우측의 인덱스이다.
        // ** 3 5 2 7로 잘라진 조각이라고 하면은 p는 0(3 위치)이고 q는 mid+1이니까 2(2 위치)
        int p = left;
        int q = mid+1;
        int idx = p; // ** idx는 tmp쪽에 쓰는 변수이다.

        while (p<=mid || q<=right) { // 인덱스 p, q가 정상 범위(유효 구간) 내에 있는지 확인한다. (중앙값 기준으로 좌, 우측 내부 범위에 속하는지를 판단한다.)
            if (p <= mid && q <= right) { // 두 값 모두가 유효 범위 내에 있을 때에는
                if (arr[p] <= arr[q]) { // 우측 값이 좌측 값보다 크다면
                    tmp[idx++] = arr[p++]; //별도 공간으로 만들어둔 tmp[p] 좌측에서부터 하나씩 늘려가면서 arr[p] 내용 넣고 p도 하나씩 증가시킨다. (정렬시키는 것이다. 작은 것부터 넣는 것.)
                } else { // ** 그러면 여기로 들어오겠지?
                    tmp[idx++] = arr[q++]; // 좌측 값이 우측 값보다 크다면 우측 값을 차례로 채워간다.
                }
            } else if (p <= mid && q > right) { // p는 중앙 값 내부에 있는데 q는 우측 값을 벗어난 경우 (오른쪽에는 데이터가 다 합쳐져서 할 게 없는 경우)
                tmp[idx++] = arr[p++];
            } else { // 좌측은 다 됐고 우측만 남았을 경우
                tmp[idx++] = arr[q++];
            }
        }
        // 위에 while문 계산해보면 (기존 배열 따와서 인덱스 변하는 거랑(left, right) tmp의 인덱스 변하는 거랑(idx) 헷갈리지 않게 잘 해야 한다 ㅠㅠ;;
        // 3 5 2 7 : tmp[0]에는 2만 들어간 상태 (3, 2 비교했더니 3<=2 아니니까 작은 걸 넣었다.)
        // 그 다음에는 3이랑 7 비교, 3<=7 되니까 tmp[1]에는 3이 들어간다 적은 게 들어가니까
        // 그 다음에는 p가 +1 돼서 5 위치에 가게 되고 5랑 7이랑 비교해봤더니 5<=7 안 되니까 5가 tmp[2]에 들어간다.
        // 그 다음에 p가 또 +1 돼서 증가가 되는데 이러면 2 위치에 가게 되는데 중간 mid를 넘어버리게 되잖아 그러면은 tmp[3]에다가 7을 넣게 된다.
        // 그러면 tmp에는 총 2 3 5 7 순서로 들어가게 되는 것이다.
        // 이것을 for 문 돌려가면서 다시 arr에다가 넣어주면 된다 ..
        // 정렬이 다 됐다고 하면은 tmp에 있는 내용을 원래 배열이었던 arr로 가져와주는 작업을 진행한다.
        for (int i=left; i<=right; i++) {
            arr[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length-1);
        System.out.println("합병 정렬 : "+Arrays.toString(arr));
    }
}